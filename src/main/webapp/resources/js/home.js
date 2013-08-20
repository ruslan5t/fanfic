
$(function() {
	$("#tagcloud").tagoSphere({
		radius: 50
	});
	$.ajax({
		url: $("#contextPath").attr("value") + "/getStatistics",
		type: "post",
		success: setStatistics
	});
	
	function setStatistics(statistics) {
		console.log(statistics);
		$("#chartContainer").dxChart({
		    dataSource: statistics,
		    series: {
		        argumentField: "day",
		        valueField: "oranges",
		        name: "My oranges",
		        type: "bar",
		        color: "orange"
		    }
		});
	}
});