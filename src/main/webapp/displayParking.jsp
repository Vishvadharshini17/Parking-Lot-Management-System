<%@ page import="com.wipro.parking.bean.ParkingBean" %>

<html>
<body>

<h2>Parking Record</h2>

<%
String message = (String) request.getAttribute("message");
ParkingBean bean =
        (ParkingBean) request.getAttribute("parkingBean");

if (message != null) {
%>
<h3><%= message %></h3>
<%
} else if (bean != null) {
%>

Vehicle Number: <%= bean.getVehicleNumber() %><br>
Slot Number: <%= bean.getSlotNumber() %><br>
Entry Date: <%= bean.getEntryDateTime() %>

<%
}
%>

</body>
</html>
