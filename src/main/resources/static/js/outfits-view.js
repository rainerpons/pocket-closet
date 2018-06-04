$(document).ready(function() {
	// GET (used in /outfits)
	$.ajax({
		type: "GET",
		dataType: "json",
		url: "http://localhost:8080/api/outfits",
		success: function(data) {
			$("#get-outfits-table").DataTable({
				"scrollX": true,
				"data": data,
				"columns" : [
					{"data" : "id"},
					{"data": "description"},
					{
						"data": "tops",
						"render": renderedClothing
					},
					{
						"data": "bottoms",
						"render": renderedClothing
					},
					{
						"data": "footwear",
						"render": renderedClothing
					},
					{
						"data": "accessories",
						"render": renderedClothing
					}
				]
			});
			console.log("data: ", data);
		},
		error: function (error) {
            alert("Error! Your outfits are unavailable at the moment.");
            console.log("ERROR: ", error);
        }
	});
});

var renderedClothing = function(data, type, row) {
	var result = new Array();
	if (data != null) {
		data.forEach(function(type) {
			result.push(type.color + " " + type.info.toLowerCase());
		});
		return result.join(', ');
	}
	return "None";
}