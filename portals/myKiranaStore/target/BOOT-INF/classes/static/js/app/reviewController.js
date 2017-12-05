'use strict';

angular.module('kiranaApp').controller('reviewController',
    ['UserService','InvoiceService', '$scope','$state','$stateParams',  function(UserService, InvoiceService, $scope,$state,$stateParams) {

    	$scope.shippingModeApplied = 'P';
    	
    	$scope.cartItems = $state.params.cartItems;
    	/* $scope.cartItemsX = [{
 	        code: 1,
 	        miniImageURL: '/fmcg/curd.jpg',
 	        price: 40.10,
 	        categoryCode: "FMCG",
 	        quantity: 1,
 	        itemUnitCount:3,
 	        finalPrice : 40.10
 	    }, {
 	    	 code: 2,
  	        miniImageURL: '/stat/pencil.png',
  	        price: 10.23,
  	        categoryCode: "STAT",
  	        quantity: 1,
  	        itemUnitCount:2,
  	      finalPrice : 10.23
 	    }, {
 	    	 code: 3,
  	        miniImageURL: '/cerl/wheat.jpg',
  	        price: 5.12,
  	        categoryCode: "CERL",
  	        quantity: 1,
  	        itemUnitCount:1,
  	        finalPrice : 5.12
 	    }];*/
 	
    	 
    	 if($scope.cartItems == null)
    		 $state.go('home');
    	 
    	 $scope.cust = {
     			name:'',
     			address:'',
     			mobile:''
     	};
    	
    	$scope.itemsInCart = $scope.cartItems ;//$state.params.itemsInCart;
    	$scope.cartItems=angular.copy($scope.itemsInCart);
    	$scope.cartTotal = calculateCartTotal();

    	//function for calculating cartTotal.
    	function calculateCartTotal(){
    		var cartTotalvalue = 0.00;
    		for(var i = $scope.cartItems.length - 1; i >= 0; i--){
    			$scope.cartItems[i].finalPrice = $scope.cartItems[i].quantity*$scope.cartItems[i].price;
    			cartTotalvalue += $scope.cartItems[i].finalPrice;
           } 
    		return cartTotalvalue;
    	}
    	
    	//function for calculating cartTotal.
    	function calculateTaxCharges(){
    		var taxTotalvalue = 0.00;
    		for(var i = $scope.cartItems.length - 1; i >= 0; i--){
    			if($scope.cartItems[i].categoryCode == 'FMCG')
    				taxTotalvalue += ($scope.cartItems[i].finalPrice*12)/100;
    			else
    				taxTotalvalue += ($scope.cartItems[i].finalPrice*10)/100;
           } 
    		return taxTotalvalue;
    	}
    	
    	
    	
    	$scope.updateQuantityChanges = function(item){//automatic reflection in array as you are altering there only.
    		if(item.quantity == undefined || item.quantity > item.itemUnitCount){
    			item.quantity=0;
    			item.finalPrice=0.00;
    			return;
    		}
    		item.finalPrice = item.quantity*item.price;
    		updateOrderDetails();
    	}
    	    	
    	$scope.order = {
    		cartTotal : calculateCartTotal(),
    		taxCharges : calculateTaxCharges(),
    		shippingCost : 0.00,
    		total : 0.00,
    		deliveryDate:''
    	};
    	
    	function updateOrderDetails(){
    		$scope.cartTotal = calculateCartTotal();
    		$scope.order.cartTotal = calculateCartTotal();
    		$scope.order.taxCharges =  calculateTaxCharges();
        	$scope.order.total = ($scope.order.cartTotal + $scope.order.taxCharges + $scope.order.shippingCost).toFixed(2);
        	$scope.order.cartTotal = $scope.order.cartTotal.toFixed(2);
        	$scope.order.taxCharges = $scope.order.taxCharges.toFixed(2);
    	}
    	
    	var d = new Date();
		d.setDate(d.getDate() + 3);
		$scope.order.deliveryDate =  d.getDate() + '/' + (d.getMonth() + 1) + '/' + d.getFullYear(); 
		
    	
    	$scope.updateShippingCharges = function(deliveryMode){
    		if(deliveryMode ==  'PickUp' && $scope.shippingModeApplied != 'P'){
    			$scope.order.shippingCost = 0;
    			$scope.order.total-=30.00;
    			$scope.shippingModeApplied = 'P';
    		}else if(deliveryMode == 'HomeDelivery' && $scope.shippingModeApplied != 'H'){
    			$scope.order.shippingCost = 30.00;
    			$scope.order.total+=30.00;
    			$scope.shippingModeApplied = 'H';
    		}
    		
    		updateOrderDetails();
    	}
    	

    	$scope.deleteItem =function(item){
            if(item != null) {
                for(var i = $scope.cartItems.length - 1; i >= 0; i--){
                   if($scope.cartItems[i].code == item.code){
                         $scope.cartItems.splice(i, 1); 
                         break;
                    }
               } 
           }  
            updateOrderDetails();
       }  	
    	
    	updateOrderDetails();
    	
    	function createInvoiceTnx (invoice) {
             InvoiceService.createInvoice(invoice).then(
                 function (invoice) {
                     $scope.invoice = invoice;
                 },
                 function (errResponse) {
                     console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
                 }
             );
         }
    
    	$scope.submitOrder = function(){
   	     	createInvoiceTnx($scope.order);
    		UserService.createUser($scope.cust);
    	     $scope.invoice = InvoiceService.getCreatedInvoice();
    		$state.go('success',{invoice:$scope.invoice , order:$scope.order, customer : $scope.cust, cart : $scope.cartItems});
    	}
    	    	
    }]);