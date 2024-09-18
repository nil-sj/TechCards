import React from 'react'
import { useContext } from 'react';
/* import AuthContext from '../../context/AuthContext'; */
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { Moon, Sun } from "lucide-react"
import { Button } from "@/components/ui/button"
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu"
import { useTheme } from "@/components/theme-provider"
import { NavLink } from 'react-router-dom'
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"
import {
  Sheet,
  SheetClose,
  SheetContent,
  SheetDescription,
  SheetFooter,
  SheetHeader,
  SheetTitle,
  SheetTrigger,
} from "@/components/ui/sheet"
import { faFolder } from '@fortawesome/free-regular-svg-icons';
import { faDumbbell, faPersonRunning, faChartLine, faComments, faBars } from '@fortawesome/free-solid-svg-icons';


const Topbar = () => {
  const { setTheme } = useTheme()
  const { theme } = useTheme();
  /* let { user, logoutUser } = useContext(AuthContext) */

  return (
    <div  className="fixed z-50 top-0 w-full h-12 lg:h-0 flex items-center justify-between p-3 pt-3 pb-4 lg:py-8 bg-background border-b md:border-none">
        <div className='flex font-bold text-3xl ml-4 text-primary'><NavLink to='/'><h1>TechCards</h1></NavLink></div>
        <div className='flex items-center'>
        
        <Sheet >
            <SheetTrigger className='md:hidden' asChild>
                <FontAwesomeIcon className='hidden' size='xl' icon={faBars} />
            </SheetTrigger>
            <SheetContent>
                <SheetHeader>
                
                </SheetHeader>
                  <ul className="flex flex-col gap-1">
                    <NavLink to='/account'>
                      <li className="flex items-center text-lg hover:bg-muted w-full h-16 pl-4 rounded-md transition duration-300 ease-in-out">
                        <Avatar className="mr-3">
                          <AvatarImage src="https://github.com/shadcn.png"/>
                          <AvatarFallback>CN</AvatarFallback>
                        </Avatar>
                        Account
                        <DropdownMenu>
                          <DropdownMenuTrigger asChild>
                            <Button variant="outline" className='ml-10' size="icon">
                              <Sun className="h-[1.2rem] w-[1.2rem] rotate-0 scale-100 transition-all dark:-rotate-90 dark:scale-0" />
                              <Moon className="absolute h-[1.2rem] w-[1.2rem] rotate-90 scale-0 transition-all dark:rotate-0 dark:scale-100" />
                              <span className="sr-only">Toggle theme</span>
                            </Button>
                          </DropdownMenuTrigger>
                          <DropdownMenuContent align="end">
                            <DropdownMenuItem onClick={() => setTheme("light")}>
                              Light
                            </DropdownMenuItem>
                            <DropdownMenuItem onClick={() => setTheme("dark")}>
                              Dark
                            </DropdownMenuItem>
                            <DropdownMenuItem onClick={() => setTheme("system")}>
                              System
                            </DropdownMenuItem>
                          </DropdownMenuContent>
                        </DropdownMenu>
                      </li>
                    </NavLink>

                    <NavLink  to="/">
                      <li className="flex items-center text-lg hover:bg-muted w-full h-16 pl-4 rounded-md transition duration-150 ease-in-out">
                        <FontAwesomeIcon  size='lg' className="mr-3" icon={faPersonRunning} />
                        Train!
                      </li>
                    </NavLink>
                    
                    <NavLink  to="/programs">
                      <li className="flex items-center text-lg hover:bg-muted w-full h-16 pl-4 rounded-md transition duration-150 ease-in-out">
                        <FontAwesomeIcon className="mr-3" icon={faFolder} />
                        Programs
                      </li>
                    </NavLink>

                    <NavLink  to="/workouts">
                      <li className="flex items-center text-lg hover:bg-muted w-full h-16 pl-4 rounded-md transition duration-150 ease-in-out">
                        <FontAwesomeIcon className="mr-3" icon={faDumbbell} />
                        Workouts
                      </li>
                    </NavLink>

                    <NavLink to='/Progress'> 
                      <li className="flex items-center text-lg hover:bg-muted w-full h-16 pl-4 rounded-md transition duration-150 ease-in-out">
                        <FontAwesomeIcon className="mr-3" icon={faChartLine} />
                        Progress
                      </li>
                    </NavLink>

                    <NavLink to='/chat'> 
                      <li className="flex items-center text-lg hover:bg-muted w-full h-16 pl-4 rounded-md transition duration-150 ease-in-out">
                        <FontAwesomeIcon className="mr-3" icon={faComments} />
                        Messages
                      </li>
                    </NavLink>
                    
                  </ul>
            </SheetContent>
        </Sheet >
          
          <NavLink to='/account'>
            <Avatar className="mr-3">
              <AvatarImage src="https://github.com/shadcn.png"/>
              <AvatarFallback>CN</AvatarFallback>
            </Avatar>
          </NavLink>
        </div>
        
    </div>
  )
}

export default Topbar