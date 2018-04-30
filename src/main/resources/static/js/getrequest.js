$(document).ready(function() {
	// GET (used in /clothing)
	$.ajax({
		type: "GET",
		dataType: "json",
		url: "http://localhost:8080/api/clothing",
		success: function(data) {
			$("#get-clothing-table").DataTable({
				"scrollX": true,
				"data": data,
				"columns" : [
					{"data" : "id"},
					{"data": "type"},
					{"data": "color"},
					{"data": "brand"},
					{"data": "info"}
				]
			});
			console.log("data: ", data);
		},
		error: function (error) {
            alert("Error! Your clothing is unavailable at the moment.");
            console.log("ERROR: ", error);
        }
	});
});