


	<nav class="navbar navbar-fixed-top navbar-inverse" >
	
			<ul class="nav navbar-nav">
	
			<li class="active">
			<a href="reqUserHome">Home <span
					class="glyphicon glyphicon-home"></span></a></li>
			
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="">Welcome ${customer.custname} <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="">Edit Profile</a></li>
					<li><a href="reqUserChangePwdPage">Change Password</a></li>
					<li><a href="j_spring_security_logout">Logout</a></li>
					<li><a href="reqMyOrders?customerid=${customer.customerid}">MyOrders</a><li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<a href="reqUserCartItem"> ${customer.cart.cartItems.size()}
          <span class="glyphicon glyphicon-shopping-cart"></span>
        </a>
        </ul>
        </li>
        </ul>
        </nav>
      
			
