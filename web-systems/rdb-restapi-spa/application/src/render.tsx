import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './app'

const domContent = document.getElementById('root') as HTMLElement
const root = ReactDOM.createRoot(domContent)
root.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>
)