const form = document.getElementById('register');

form.addEventListener('submit', function (evt) {
    evt.preventDefault();
    getUserData();

    // (async () => {
    //     await fetch('http://localhost/post', {
    //         method: 'POST',
    //         headers: {
    //             'Accept': 'application/json',
    //             'Content-Type': 'application/json'
    //         },
    //         body: getUserData(),
    //     });
    //
    // })();
});

function getUserData() {
    const user = {};

    for (let i = 0; i < form.elements.length; i++) {
        let item = form.elements.item(i);
        user[item.name] = item.value;
    }

    return singleton.getUser(user);
}

const singleton = (function () {
    let userInstance;

    function User(name, email, password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    return {
        getUser: function (user) {
            if (!userInstance) {
                userInstance = new User(user.name, user.email, user.password);
            }
            return userInstance;
        }
    }
})();
