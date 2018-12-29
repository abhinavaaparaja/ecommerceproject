 <%@ include file="/WEB-INF/views/links.jsp" %> 

<%@ page isELIgnored="false" %>

<%@ include file="/WEB-INF/views/user_navibar.jsp"%>
<div class="container-wrapper" style="margin-top:50px; margin-bottom:50px;">
    <div class="container" style="background-color:#d7edf4">
        <div class="page-header">
            <h1>Cutomer</h1>

            <p class="lead">Customer Details:</p>
        </div>

        <spring:form commandName="order" class="form-horizontal">

        <h3>Shipping Address:</h3>

        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <spring:input path="cart.customer.shippingAddress.street" class="form-Control" />
        </div>

      

        <div class="form-group">
            <label for="shippingCity">City</label>
            <spring:input path="cart.customer.shippingAddress.city" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <spring:input path="cart.customer.shippingAddress.state" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <spring:input path="cart.customer.shippingAddress.country" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingZip">Zipcode</label>
            <spring:input path="cart.customer.shippingAddress.pincode" class="form-Control" />
        </div>

        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>

        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected" />

        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

        </spring:form>
        

<%@ include file= "/WEB-INF/views/footer.jsp" %>
        </div>
        </div>
