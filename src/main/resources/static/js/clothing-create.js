$(document).ready(function() {
	// SUBMIT FORM
	$("#create-star-form").submit(function(event) {
		event.preventDefault();
		ajaxPost();
	});

	function ajaxPost() {
		// PREPARE FORM DATA
		var formData = {
			type : $("#type").val(),
			color : $("#color").val(),
			brand : $("#brand").val(),
			info : $("#info").val()
		}

		// LOG INTO CONSOLE
		console.log("formData: " + formData);

		// DO POST
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8080/api/clothing",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				alert("Your clothing entry was entered successfully!");
				console.log(result);
			},
			error : function(error) {
				alert("Error! Your clothing entry was unsuccessful.");
				console.log("ERROR: ", error);
			}
		});
	}
})