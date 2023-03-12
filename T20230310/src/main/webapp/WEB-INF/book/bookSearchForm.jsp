<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>




<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Clean Blog - Start Bootstrap Theme</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet"
        type="text/css" />
    <link
        href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
        rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="resources/css/styles.css" rel="stylesheet" />
</head>

<body>
    <!-- Navigation-->
    <jsp:include page="../includes/top.jsp"></jsp:include>
    <!-- Page Header-->
    <jsp:include page="../includes/header.jsp"></jsp:include>

    <!-- Main Content-->
    <div class="container px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-md-12 col-lg-10 col-xl-8">
               	<form action="bookSearchControl.do" method="post">
                <table class="table">
                    <tbody>
                    	<tr >
                            <td align="center" colspan="2">도서 검색기능 입니다. 원하는 도서의 제목을 입력하세요</td>
                        </tr>
                        <tr>
                            <td>도서의 풀네임</td>
                            <td><input type="text" name="book_search" placeholder="제목" required="required"></td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2">
                                <input class="btn btn-primary" type="submit" value="검색">
                        </tr>
                    </tbody>
                </table>
                </form>
            </div>
        </div>
    </div>

    <!-- Footer-->
    <jsp:include page="../includes/footer.jsp"></jsp:include>

    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="resources/js/scripts.js"></script>
</body>

</html>