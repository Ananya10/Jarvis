<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Recruiter</title>

<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
<script>

    function submitForm(btn){
        var frm = document.jobIDForm;

        frm.action = btn.value;
        if(btn.value == "home.html"){
        	frm.method = "get";
        }
        frm.submit();
        return false;

    }

</script>
	<div class="container-fluid">
		<div class="row" style="background: -webkit-linear-gradient(left, #cccccc, #ebebe0, #000000);">
			<div class="col-md-10" style="display: inline-block; vertical-align: middle; float: none;">
				<img alt="Bootstrap Image Preview" src="images/Logo3.png"
					height="125px">
			</div>
			<div class="col-md-1" style="display: inline-block; vertical-align: middle; float: none;">
				<label style="color:white;">${sessionScope.userName}</label>
			</div>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-12">
				<div class="tabbable" id="tabs-769811">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-912557" data-toggle="tab">Applicant
								Data</a></li>
						<li><a href="#panel-244497" data-toggle="tab">Current
								Employee Data</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-912557">
							<br> <br>
							<div class="container-fluid">
								<form:form class="form-horizontal" method="post"
									action='' name="jobIDForm" id="jobIDForm"
									modelAttribute="jobListing">
									<div class="row">
										<div class="col-md-2">
											<label for="inputJobId">Job id </label>
										</div>
										<div class="col-md-2">
											<input type="text" class="form-control" id="inputJobId"
												name="inputJobId" style="width: 200px;"
												value="${jobListing.jobID}">
										</div>
										<div class="col-md-2">
											<button id="button" value="home1.html" class="btn btn-default"
												onclick="submitForm(this)">Search</button>
										</div>
										<div class="col-md-2"></div>
										<div class="col-md-2"></div>
										<div class="col-md-2"></div>
									</div>
									<br>
									<br>
									<div class="row">
										<div class="col-md-12">
											<table class="table">
												<thead>
													<tr>
														<th>Application Status</th>
														<th>Email id</th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${jobListing.candidateDetails}"
														var="candidate" varStatus="i" begin="0">
														<tr class = ${candidate.colorClass}>
															<td>${candidate.applicationStatus}</td>
															<td>${candidate.email}</td>
															<td>
																<div class="radio">
																	<label> <input type="radio" name="optradio">
																	</label>
																</div>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="col-md-2">

											<button id="button" value="recruit.html"
												class="btn btn-default" onclick="submitForm(this)">Submit</button>
										</div>
										<div class="col-md-2"></div>
										<div class="col-md-2"></div>
										<div class="col-md-2"></div>
										<div class="col-md-2"></div>
										<div class="col-md-2"></div>
									</div>
								</form:form>
							</div>

						</div>
						<div class="tab-pane" id="panel-244497">

							<br> <br>

							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">

										<form role="form">
											<div class="form-group">

												<label for="exampleInputFile">Employee Test Data</label> <input
													type="file" id="exampleInputFile" />

											</div>
											<button type="submit" class="btn btn-default">
												Submit</button>
										</form>
									</div>
								</div>

								<br> <br>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>