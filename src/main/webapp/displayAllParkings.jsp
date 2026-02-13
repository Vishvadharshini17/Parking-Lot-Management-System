<%@ page import="java.util.*" %>
<%@ page import="com.wipro.parking.bean.ParkingBean" %>

<html>
<body>

<h2>All Parking Records</h2>

<%
String message = (String) request.getAttribute("message");
List<ParkingBean> list =
        (List<ParkingBean>) request.getAttribute("parkingList");

if (message != null) {
%>
<h3><%= message %></h3>
<%
} else {
%>

<table border="1">
<tr>
<th>Vehicle</th>
<th>Slot</th>
<th>Entry Time</th>
</tr>

<%
for (ParkingBean bean : list) {
%>
<tr>
<td><%= bean.getVehicleNumber() %></td>
<td><%= bean.getSlotNumber() %></td>
<td><%= bean.getEntryDateTime() %></td>
</tr>
<%
}
%>

</table>

<%
}
%>

</body>
</html>
