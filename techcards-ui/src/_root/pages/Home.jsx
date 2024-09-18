import React from 'react'
import { Button } from '@/components/ui/button'
import { NavLink } from 'react-router-dom'

const Home = () => {
  return (
    <div className="bg-deafult flex gap-4 h-screen flex items-center justify-center gap-x-4">
        <div>
            <h1 className='text-6xl font-bold text-primary' style={{
              background: "linear-gradient(to right, #4facfe, #00f2fe)", // Blue to light cyan gradient
              WebkitBackgroundClip: "text",
              color: "transparent"
            }}>TechCards</h1>
            <h1 className='text-4xl font-semibold'>Learn from the best resources</h1>
            <NavLink to='/userauth'>
              <Button className='mt-4'>Login</Button>
            </NavLink>
            <NavLink to='/feed'>
              <Button variant='secondary' className='mt-4 ml-4'>Try as guest</Button>
            </NavLink>
        </div>
    </div>
  )
}

export default Home