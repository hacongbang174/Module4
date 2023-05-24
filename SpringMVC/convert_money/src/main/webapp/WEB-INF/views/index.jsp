<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>
<form action="/convert" method="post">
    <h3>Nhập lượng USD mà bạn muốn chuyển đổi</h3>
    <input type="number" name="usd" value=""> $
    <h3>Số tiền VNĐ bạn nhận được sau khi chuyển đổi: ${vnd} VNĐ</h3>
    <button type="submit" value="Convert">Convert</button>
</form>
</body>
</html>