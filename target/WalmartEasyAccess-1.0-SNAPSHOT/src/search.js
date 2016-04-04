/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.body.onready = function() {
	document.getElementById('query').focus();
}

$(document).ready(function() {
	$('#query').keypress(function (e) {
		if (e.which == 13) {
			$('#search').focus().click();
			return false;
		}
	});
	
	$('#search').click(function() {
		$('#loading').fadeIn("slow");
		$.post("Search", { query: $('#query').val() }, function(result) {
			$('#loading').fadeOut("slow");
			$('#results').html(result);
		})
	})
})