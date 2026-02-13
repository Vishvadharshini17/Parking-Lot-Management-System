package com.wipro.parking.service;

import java.util.Date;
import java.util.List;

import com.wipro.parking.bean.ParkingBean;
import com.wipro.parking.dao.ParkingDAO;
import com.wipro.parking.util.InvalidInputException;

public class Administrator {

    ParkingDAO dao = new ParkingDAO();

    public String addRecord(ParkingBean bean) {

        try {

            if (bean == null || bean.getVehicleNumber() == null
                    || bean.getEntryDateTime() == null)
                throw new InvalidInputException();

            if (bean.getVehicleNumber().length() < 2)
                return "INVALID VEHICLE NUMBER";

            if (dao.recordExists(bean.getVehicleNumber(),
                    bean.getEntryDateTime()))
                return "ALREADY EXISTS";

            String id = dao.generateRecordID(
                    bean.getVehicleNumber(),
                    bean.getEntryDateTime());

            bean.setRecordId(id);

            return dao.createRecord(bean);

        } catch (InvalidInputException e) {
            return "INVALID INPUT";
        }
    }

    public ParkingBean viewRecord(String vehicleNumber,
                                  Date entryDateTime) {

        return dao.fetchRecord(vehicleNumber, entryDateTime);
    }

    public List<ParkingBean> viewAllRecords() {

        return dao.fetchAllRecords();
    }
}
