$(document).ready(function() {
    $.ajax({
        url: "https://address-book-123456789.herokuapp.com/"
    }).then(function(data) {
        $('.greeting-id').append(data.name);
        $('.greeting-content').append(data.address);
    });
});