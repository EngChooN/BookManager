<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>SB Admin 2 - Tables</title>

    <!-- Custom fonts for this template -->
    <link
      href="../resources/admin/vendor/fontawesome-free/css/all.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet"
    />

    <!-- Custom styles for this template -->
    <link href="../resources/admin/css/sb-admin-2.min.css" rel="stylesheet" />

    <!-- Custom styles for this page -->
    <link
      href="../resources/admin/vendor/datatables/dataTables.bootstrap4.min.css"
      rel="stylesheet"
    />
  </head>

  <body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
     	<!-- Sidebar -->
    	<jsp:include page="/WEB-INF/views/admin/include/sidebar.jsp" flush="false" />

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
          	<!-- Top bar -->
			<jsp:include page="/WEB-INF/views/admin/include/topbar.jsp" flush="false" />

          <!-- Begin Page Content -->
          <div class="container-fluid">
            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">회원관리</h1>
            

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">
                  회원관리
                </h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table
                    class="table table-bordered"
                    id="dataTable"
                    width="100%"
                    cellspacing="0"
                  >
                    <thead>
                      <tr>
                        <th>Member Id</th>
                        <th>Member password</th>
                        <th>Member Name</th>
                        <th>Etc</th>
                        <th>회원정보수정</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>Member Id</th>
                        <th>Member password</th>
                        <th>Member Name</th>
                        <th>Etc</th>
                        <th>회원정보수정</th>
                      </tr>
                    </tfoot>
                    <tbody>
                      <c:forEach var="memberlist" items="${list}">
                      		<tr>
                      			<td>
                      			[${memberlist.mid}]
                      			</td>
                      			<td>
                      			${memberlist.mpass}
                      			</td>
                      			
                      			<c:set var="mname" value="${memberlist.mname}"/>
                      			<td>
                      			<c:choose>
                      				<c:when test="${memberlist.mname=='관리자'}">
                      				<span style="color:red">관리자</span>
                      				</c:when>
                      				<c:otherwise>
                      					${memberlist.mname}
                      				</c:otherwise>
                      			</c:choose>
                      			</td>
                      			
                      			<td>
                      			${memberlist.etc}
                      			</td>
                      			<td>
                      	<form action="./mmUpdate" method="get" style="display:inline-block">
                      			<input style="display:none;" name="mid" value="${memberlist.mid}">
                      			<input style="display:none;" name="mpass" value="${memberlist.mpass}">
                      			<input style="display:none;" name="mname" value="${memberlist.mname}">
                      			<input style="display:none;" name="etc" value="${memberlist.etc}">
					 			<input type="submit" class="crudButton" value="수정">
                      	</form>
						<form action="deleteAction" method="post" style="display:inline-block">
							<input style="display: none;" name="mid" value="${memberlist.mid}"> 
							<input type="submit" class="crudButtonD" value="삭제">
						</form>
					 			</td>
					 			</tr>
								
					</c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <jsp:include page="/WEB-INF/views/admin/include/footer.jsp" flush="false" />
        <!-- End of Footer -->
      </div>
      <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="../resources/admin/vendor/jquery/jquery.min.js"></script>
    <script src="../resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../resources/admin/javascripts/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="../resources/admin/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="../resources/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="../resources/admin/javascripts/demo/datatables-demo.js"></script>
  </body>
</html>
