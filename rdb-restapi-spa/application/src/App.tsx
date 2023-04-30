import React from 'react'

const App = () => {
    return (
        <React.Fragment>
            <h1>Register Form</h1>
            <form action="/" method="POST" />
            name <input type="text" name="name" />
            <br />
            <button type="submit">Register</button>
        </React.Fragment>
    )
}

export default App