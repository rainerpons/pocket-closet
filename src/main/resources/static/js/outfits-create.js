$(document).ready(function() {
	// GET FORM DATA
	$("#")
	
	// SUBMIT FORM
	$("#create-outfit-form").submit(function(event) {
		event.preventDefault();
		ajaxPost();
	});

	function ajaxPost() {
		// PREPARE FORM DATA
		var formData = {
			tops: $("#tops").val(),
			bottoms: $("#bottoms").val(),
			footwear: $("#footwear").val(),
			accessories: $("#accessories").val()
		}

		// LOG INTO CONSOLE
		console.log("formData: " + formData);

		// DO POST
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8080/api/outfits",
			data : JSON.stringify(formData),
			dataType : "json",
			success : function(result) {
				alert("Your outfit entry was entered successfully!");
				console.log(result);
			},
			error : function(error) {
				alert("Error! Your outfit entry was not successful.");
				console.log("ERROR: ", error);
			}
		});
	}
})