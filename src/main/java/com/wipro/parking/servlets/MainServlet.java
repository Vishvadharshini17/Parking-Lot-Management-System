package com.wipro.parking.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.wipro.parking.bean.ParkingBean;
import com.wipro.parking.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Administrator admin = new Administrator();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    public ParkingBean viewRecord(HttpServletRequest request) {

        try {
            String vehicle = request.getParameter("vehicleNumber");

            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
                    .parse(request.getParameter("entryDateTime"));

            return admin.viewRecord(vehicle, date);

        } catch (Exception e) {
            return null;
        }
    }

    public List<ParkingBean> viewAllRecords(HttpServletRequest request) {

        return admin.viewAllRecords();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        try {

        
            if ("newRecord".equals(operation)) {

                ParkingBean bean = new ParkingBean();

                bean.setVehicleNumber(request.getParameter("vehicleNumber"));
                bean.setSlotNumber(request.getParameter("slotNumber"));

                Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
                        .parse(request.getParameter("entryDateTime"));

                bean.setEntryDateTime(date);

                String result = admin.addRecord(bean);

                if (result.equals("FAIL")) {
                    response.sendRedirect("error.html");
                } else {
                    response.sendRedirect("success.html");
                }
            }

          
            else if ("viewRecord".equals(operation)) {

                ParkingBean bean = viewRecord(request);

                if (bean == null) {
                    request.setAttribute("message",
                            "No matching records exists! Please try again!");
                } else {
                    request.setAttribute("parkingBean", bean);
                }

                RequestDispatcher rd =
                        request.getRequestDispatcher("/displayParking.jsp");
                rd.forward(request, response);
            }

            else if ("viewAllRecords".equals(operation)) {

                List<ParkingBean> list = viewAllRecords(request);

                if (list == null || list.isEmpty()) {
                    request.setAttribute("message",
                            "No records available!");
                } else {
                    request.setAttribute("parkingList", list);
                }

                RequestDispatcher rd =
                        request.getRequestDispatcher("/displayAllParkings.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            response.sendRedirect("error.html");
        }
    }
}
