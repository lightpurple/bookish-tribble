// import logo from './logo.svg';
// import styles from './App.module.css';
import { createSignal, createResource } from 'solid-js';

const fetchLogin = async ({userEmail, userPassword}) =>
    (await fetch(`http://localhost:8080/users`)).json();

const fetchUsers = async () =>
    (await fetch('http://localhost:8080/users')).json();

function App() {
    // const [userEmail, setUserEmail] = createSignal();
    // const [userPassword, setUserPassword] = createSignal();

    // const [login] = createResource({userEmail, userPassword}, fetchLogin)
    const [users] = createResource(fetchUsers);

    return (
        // <div class={styles.App}>
        //   <header class={styles.header}>
        //     <img src={logo} class={styles.logo} alt="logo" />
        //     <p>
        //       Edit <code>src/App.jsx</code> and save to reload.
        //     </p>
        //     <a
        //       class={styles.link}
        //       href="https://github.com/solidjs/solid"
        //       target="_blank"
        //       rel="noopener noreferrer"
        //     >
        //       Learn Solid
        //     </a>
        //   </header>
        // </div>
        <>
        {/* <input
            type={"email"}
            placeholder="Enter Your Email"
            onInput={(e) => setUserEmail(e.currentTarget.value)}
        />
        <br></br>
        <input
            type={"password"}
            placeholder="Enter Your Password"
            onInput={(e) => setUserPassword(e.currentTarget.value)}
        />
        <br></br>
        <button>Login</button> */}

        <div>
            <pre>{JSON.stringify(users(), null, 4)}</pre>
        </div>
        </>

    );
}

export default App;
