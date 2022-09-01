var createUrlWithParams = function (url, params) {
    var searchParams = new URLSearchParams(params);
    return url + '?' + searchParams.toString();
};
var url = 'http://localhost/';
var params = {
    user: 'user',
    userId: '100'
};
console.log(createUrlWithParams(url, params));
