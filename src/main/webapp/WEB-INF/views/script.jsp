<script>
	$(document).ready(
			function() {
				var searchCondition = '${searchCondition}';
				$('.table').DataTable(
						{
							"lengthMenu" : [ [ 5, 10, 15, -1 ],
									[ "Five", "Ten", "Fifteen", "All" ] ],
							"oSearch" : {"sSearch" : searchCondition
							}
						})
			});
</script>
