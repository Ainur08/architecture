const form = document.getElementById('auth');

form.addEventListener('submit', function (evt) {
    evt.preventDefault();
    getUserData();
});
