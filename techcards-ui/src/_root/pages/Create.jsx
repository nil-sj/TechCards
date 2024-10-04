import React, {useState} from 'react'
import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
  } from "@/components/ui/card"
  import { Input } from "@/components/ui/input"
  import { Textarea } from "@/components/ui/textarea"
  import { Button } from "@/components/ui/button"
  import axios from 'axios'


  

const Create = () => {
    const [name, setName] = useState('');
    const [url, setUrl] = useState('');
    const [image, setImage] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault(); 
        
        const newTechCard = {
          name,
          url,
          image,
          description,
          
        };
    
        try {
         
          const response = await axios.post('http://localhost:8080/api/techcards', newTechCard);
         console.log('TechCard created successfully:', response.data);
          alert('TechCard created successfully!');
    
          setName('');
          setUrl('');
          setImage('');
          setDescription('');
        } catch (error) {
          
          console.error('Error creating TechCard:', error);
          alert('Failed to create TechCard. Please try again.');
        }
      };
  return (
    <Card className=" flex flex-col items-center p-4 border-0 md:border h-full w-full rounded-none md:rounded-xl">
        <CardHeader>
          <CardTitle className= 'text-3XL'>Create New Tech Card</CardTitle>
        </CardHeader>
    <form onSubmit={handleSubmit} className='w-1/2'>
        <div className='flex flex-col gap-4'>
        <Input
                type="text"
                placeholder="Tech Card name"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
                />
                <Input
                    type="text"
                    placeholder="URL"
                    value={url}
                    onChange={(e) => setUrl(e.target.value)}
                    required
                />
                <Input
                    type="text"
                    placeholder="Image URL"
                    value={image}
                    onChange={(e) => setImage(e.target.value)}
                    required
                />
                <Textarea
                    placeholder="Type your description here."
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    required
                />
                <Button type="submit">Create</Button>
        </div>
     </form>
    
    </Card>
    
  
  )
}

export default Create