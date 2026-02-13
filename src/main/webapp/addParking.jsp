<!DOCTYPE html>
<html>
<body>

<h2>Add Parking Record</h2>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="newRecord">

Vehicle Number: <input type="text" name="vehicleNumber"><br><br>
Slot Number: <input type="text" name="slotNumber"><br><br>
Entry Date Time:
<input type="datetime-local" name="entryDateTime"><br><br>

<input type="submit" value="Add">

</form>

</body>
</html>
