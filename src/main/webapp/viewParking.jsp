<!DOCTYPE html>
<html>
<body>

<h2>View Parking Record</h2>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="viewRecord">

Vehicle Number: <input type="text" name="vehicleNumber"><br><br>
Entry Date Time:
<input type="datetime-local" name="entryDateTime"><br><br>

<input type="submit" value="View">

</form>

</body>
</html>
