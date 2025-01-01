/* eslint-disable @typescript-eslint/no-unused-vars */
interface Window {
    env: {
        REACT_APP_API_URL: string;
    };
}

window.env = {
    REACT_APP_API_URL: 'http://gateway:8888', // This will be set dynamically at runtime
};