package com.wipro.parking.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wipro.parking.bean.ParkingBean;
import com.wipro.parking.util.DBUtil;

public class ParkingDAO {

    public String createRecord(ParkingBean bean) {

        String status = "FAIL";

        try (Connection con = DBUtil.getDBConnection()) {

            String sql = "INSERT INTO PARKING_TB VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bean.getRecordId());
            ps.setString(2, bean.getVehicleNumber());
            ps.setString(3, bean.getSlotNumber());
            ps.setTimestamp(4, new Timestamp(bean.getEntryDateTime().getTime()));

            if (bean.getExitDateTime() != null)
                ps.setTimestamp(5, new Timestamp(bean.getExitDateTime().getTime()));
            else
                ps.setNull(5, Types.TIMESTAMP);

            ps.setInt(6, bean.getCharges());
            ps.setString(7, bean.getRemarks());

            int row = ps.executeUpdate();

            if (row > 0)
                status = bean.getRecordId();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public ParkingBean fetchRecord(String vehicleNumber, Date entryDateTime) {

        ParkingBean bean = null;

        try (Connection con = DBUtil.getDBConnection()) {

            String sql = "SELECT * FROM PARKING_TB WHERE VEHICLENUMBER=? AND ENTRY_DATETIME=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, vehicleNumber);
            ps.setTimestamp(2, new Timestamp(entryDateTime.getTime()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                bean = new ParkingBean();

                bean.setRecordId(rs.getString("RECORDID"));
                bean.setVehicleNumber(rs.getString("VEHICLENUMBER"));
                bean.setSlotNumber(rs.getString("SLOTNUMBER"));
                bean.setEntryDateTime(rs.getTimestamp("ENTRY_DATETIME"));
                bean.setExitDateTime(rs.getTimestamp("EXIT_DATETIME"));
                bean.setCharges(rs.getInt("CHARGES"));
                bean.setRemarks(rs.getString("REMARKS"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public String generateRecordID(String vehicleNumber, Date entryDateTime) {

        String id = "";

        try (Connection con = DBUtil.getDBConnection()) {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT PARKING_SEQ.NEXTVAL FROM DUAL");
            rs.next();

            int seq = rs.getInt(1);

            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String date = format.format(entryDateTime);

            String prefix = vehicleNumber.substring(0, 2).toUpperCase();

            id = date + prefix + seq;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public boolean recordExists(String vehicleNumber, Date entryDateTime) {

        return fetchRecord(vehicleNumber, entryDateTime) != null;
    }

    public List<ParkingBean> fetchAllRecords() {

        List<ParkingBean> list = new ArrayList<>();

        try (Connection con = DBUtil.getDBConnection()) {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PARKING_TB");

            while (rs.next()) {

                ParkingBean bean = new ParkingBean();

                bean.setRecordId(rs.getString("RECORDID"));
                bean.setVehicleNumber(rs.getString("VEHICLENUMBER"));
                bean.setSlotNumber(rs.getString("SLOTNUMBER"));
                bean.setEntryDateTime(rs.getTimestamp("ENTRY_DATETIME"));
                bean.setExitDateTime(rs.getTimestamp("EXIT_DATETIME"));
                bean.setCharges(rs.getInt("CHARGES"));
                bean.setRemarks(rs.getString("REMARKS"));

                list.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
