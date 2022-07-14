import React, { useEffect } from 'react'

export default function Delayed() {
    useEffect(() => {
        const timeout = setTimeout(() => {
            console.log("Delayed")
        },2000);
        return () => clearTimeout(timeout)
    }, [])
    return (
    <div>D</div>
    )
}
