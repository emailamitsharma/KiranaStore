var app = angular.module('kiranaApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: window.location.href.split('#')[0],
    USER_SERVICE_API : window.location.href.split('#')[0] +  '/api/user/',
    INVOICE_SERVICE_API:window.location.href.split('#')[0] +  '/api/invoice/',
    ITEM_SERVICE_API :window.location.href.split('#')[0] +  '/api/item/list/',
    CATEGORY_SERVICE_API :window.location.href.split('#')[0] +  '/api/category/',
    CUSTOMER_SERVICE_API :window.location.href.split('#')[0] +  '/api/customer/'    	

});

app.config(['$stateProvider', '$urlRouterProvider','$locationProvider',
    function($stateProvider, $urlRouterProvider,$locationProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/listTemplate',
                controller:'categoryController',
                controllerAs:'ctrl',
                resolve: {
                    categories: function ($q, CategoryService , ItemService) {
                        console.log('Load all categories');
                        var deferred = $q.defer();
                        CategoryService.loadAllCategories().then(deferred.resolve, deferred.resolve);
                        ItemService.loadAllItems().then(deferred.resolve, deferred.resolve);
                    }
                }
            }).state('review',{
            	url:'/review',
            	templateUrl: 'partials/reviewOrder',
            	controller:'reviewController',
            	controllerAs:'reviewCtrl',  
            	params :{
            		cartItems:null
            	}
            }).state('success',{
            	url:'/success',
            	controller:'tnxSuccessCtrl',
            	params:{invoice:null,order:null, customer : null, cart : null},
            	template: ' <style>.shopping-item {display:none;}</style> <div class="container"><div class="pageBody midSection"><div class="well"><div class="well text-center margin0"><span class="icon-success"></span><h1 class="color-blue">You have completed your transaction successfully. Your reference number for transaction is : {{tnxId}}.</br> You will also receive an SMS on {{cust.mobile}} with delivery details.</h1></div></div></div></div>'            
            });
        
        $urlRouterProvider.otherwise('/');
    }]);

