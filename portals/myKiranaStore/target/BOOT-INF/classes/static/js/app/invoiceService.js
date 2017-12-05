'use strict';

angular.module('kiranaApp').factory('InvoiceService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllInvoices: loadAllInvoices,
                getAllInvoices: getAllInvoices, 
                createInvoice: createInvoice,
                getInvoice:getInvoice,
                getCreatedInvoice:getCreatedInvoice
            };

            return factory;

            function loadAllInvoices() {
                console.log('Fetching all categories');
                var deferred = $q.defer();
                $http.get(urls.INVOICE_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all invoices');
                            $localStorage.invoices = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading invoices');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllInvoices(){
                return $localStorage.invoices;
            }
            
            function getCreatedInvoice(){
            	return $localStorage.invoice;
            }
            
            function getInvoice(id) {
                console.log('Fetching User with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.INVOICE_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully User with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading user with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createInvoice(invoice) {
                console.log('Creating invoice');
                var deferred = $q.defer();
                $http.post(urls.INVOICE_SERVICE_API, invoice)
                    .then(
                        function (response) {
                        	$localStorage.invoice = response.data;
                           return (response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating invoice : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);