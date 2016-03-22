/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
	$('#search').click(function() {
		$.post("Search", { query: $('#query').val() }, function(result) {
			console.log(result);
			$('#results').html(result);
		})
	})
})
