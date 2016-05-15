<!DOCTYPE html>
<html lang="en">
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
<script type="text/javascript">
window.onload = function() {
	$("a[href='${sessionScope.tabID}']").click();
	};
</script>
	<div class="container-fluid">
		<div class="row"
			style="background: -webkit-linear-gradient(left, #cccccc, #ebebe0, #000000);">
			<div class="col-md-10"
				style="display: inline-block; vertical-align: middle; float: none;">
				<img alt="Bootstrap Image Preview" src="images/Logo3.png"
					height="125px">
			</div>
			<div class="col-md-1"
				style="display: inline-block; vertical-align: middle; float: none;">
				<label style="color: white;">${sessionScope.userName}</label>
			</div>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-12">
				<div class="tabbable" id="tabs-769811">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-912557" data-toggle="tab">Resume
								Screening </a></li>
						<li><a href="#panel-244497" data-toggle="tab"> Coding
								Test</a></li>
						<li><a href="#panel-244498" data-toggle="tab">Interviewer
								Feedback</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-912557">
							<br> <br>
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-2">
										<a class="btn"
											href="https://www.dropbox.com/s/pgqrnwgo516xssf/Resume.pdf?dl=0"
											target="_blank">View Resume »</a>
									</div>
								</div>
								<br /> <br />
								<div class="row">
									<div class="form-group">
										<label for="comment">Resume Summary:</label>
										<textarea class="form-control" rows="5" id="comment">${sessionScope.summary}</textarea>
									</div>
								</div>
							</div>

						</div>
						<div class="tab-pane" id="panel-244497">

							<br> <br>
							<div class="container-fluid">

								<form method="POST" enctype="multipart/form-data"
									action="prediction.html">
									<div class="row">
										<div class="col-md-2">
											<label for="applicantScore">Applicant Score: </label>
										</div>
										<div class="col-md-2">
											<input type="text" class="form-control" id="applicantScore"
												name="applicantScore" style="width: 200px;" value=${codingTest.score}>
										</div>
										<div class="col-md-2">
											<button id="button" value="" class="btn btn-default">Get
												Predictive Rating</button>
										</div>
									</div>

									<br /> <br />
									<div class="row">
										<div class="col-md-2">
											<label for="applicantScore">Predictive Rating: </label>
										</div>
										<div class="col-md-2">
										<label id="applicantScore" style="width: 200px;">${codingTest.rating}</label>
											
										</div>
									</div>
								</form>
								<br /> <br />
								<div class="row">
									<div class="col-md-2">
										<label for="maxScore">Employees' max score is:</label>
									</div>
									<div class="col-md-2">
										<p id="maxScore">90</p>
									</div>
									<div class="col-md-2">
										<label for="avgScore">Employees' Avg score is:</label>
									</div>
									<div class="col-md-2">
										<p id="avgScore">55</p>
									</div>

								</div>
							</div>

						</div>

						<div class="tab-pane" id="panel-244498">

							<br> <br>

							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">

										<form method="POST" enctype="multipart/form-data"
											action="feedback.html">
											<div class="form-group">

												<label for="exampleInputFile2">Interviewer Feedback
													Data</label> <input type="file" id="exampleInputFile2"
													name="exampleInputFile2" />

											</div>
											<button type="submit" class="btn btn-default">
												Submit</button>
										</form>
									</div>
								</div>

								<br> <br>

								<div class="row">
									<div class="col-md-12">

										<label>Feedback:</label> <label>${result.text}</label>

									</div>

								</div>

								<div class="row">
									<div class="col-md-12">
										<label>Sentiment:</label> <label style="color: green;">${result.sentiment}</label>

									</div>

								</div>

								<div class="row">
									<div class="col-md-12">

										<label>Score:</label> <label>${result.score}</label>

									</div>

								</div>

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