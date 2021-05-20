const form = document.getElementById('register');
const authForm = document.getElementById('auth');

form.addEventListener('submit', function (evt) {
    evt.preventDefault();
    let user = getUserData();

    signUp(user);
});

authForm.addEventListener('submit', function (evt) {
    evt.preventDefault();
    let user = getUserData();

    signIn(user)
});

function getUserData() {
    const user = {};

    for (let i = 0; i < form.elements.length - 1; i++) {
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

function signUp(user) {
    (async () => {
        await fetch('http://localhost:80/signUp', {
            method: 'POST',
            mode: 'no-cors',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user),
        });
    })();
}

function signIn(user) {
    (async () => {
        await fetch('http://localhost:80/signIn', {
            method: 'POST',
            mode: 'no-cors',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user),
        });
    })();
}
