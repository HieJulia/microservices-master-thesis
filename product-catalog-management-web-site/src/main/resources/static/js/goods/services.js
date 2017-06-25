"use strict"

angular.module("product-catalog-management-app")
    .value("goodsBasePath","/site/api/v1/product-catalog-service/goods")
    .service("goodsService", ["goodsBasePath","$q", "$http", function (goodsBasePath, $q, $http) {

        function baseRestExec(method, path, goodsData, successExtractorDataFn, errorExtractorDataFn) {
            var defer = $q.defer();
            var request = {method: method,url: path};
            if(goodsData){
                request.data = goodsData
            }
            $http(request).
                then(function (data) {defer.resolve(successExtractorDataFn(data));},
                function (data) {defer.reject(errorExtractorDataFn(data));});
            return defer.promise;
        }
        var goodsListExtractor = function(data) {
            var result = [];
            if(data){
                result = data.data["_embedded"] || [];
                result = result.goodsList || [];
            }

            return result;
        };

        return {
            "findAll":function () {
                return baseRestExec('GET', goodsBasePath, null, goodsListExtractor, null);
            },
            "find":function (goodsId) {
                return baseRestExec('GET', [goodsBasePath,goodsId].join('/'),null
                    ,goodsListExtractor,null);
            },
            "create":function (goodsData) {
                return baseRestExec('POST', goodsBasePath, goodsData, goodsListExtractor,null);
            },
            "edit":function (goodsId, goodsData) {
                return baseRestExec('PUT', [goodsBasePath, goodsId].join('/'), goodsData, goodsListExtractor,null);
            },
            "delete":function (goodsId) {
                var extractor = function() {return true;};
                var errorExtractor = function() {return false;};

                return baseRestExec('DELETE', [goodsBasePath,goodsId].join('/'),
                    goodsListExtractor,errorExtractor);
            }
        }
    }]);