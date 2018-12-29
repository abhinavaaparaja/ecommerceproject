
<c:if test="${not empty message}">
		<div class="container">
			<c:if test="${message.messageType.equals('INF')}">
			<div class="alert alert-success alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Success!</strong> ${message.messageBody}
			</div>
			</c:if>
			<c:if test="${message.messageType.equals('ERR')}">
			<div class="alert alert-danger alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong> ${message.messageBody}
			</div>
			</c:if>
		</div>
	</c:if>
	