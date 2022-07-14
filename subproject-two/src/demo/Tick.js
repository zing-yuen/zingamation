import { useState, useEffect } from 'react';

export default function Tick() {
    const [currentTime, setCurrentTime] = useState(new Date().toLocaleTimeString())

    useEffect(() => {
        const interval = setInterval(() => {
            setCurrentTime(new Date().toLocaleTimeString())
        },1000);
        return () => clearInterval(interval)
    },[])
    return (
        <div>
            <h2>It is {currentTime} </h2>
        </div>
    );
}
