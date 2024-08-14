# wh-backend

# Example Flowchart
    


```mermaid
flowchart TD



    S[Signup] --> S1[First Name, Last Name]
    S1 --> S2[Email Address]
    S2 --> S3[Login through Gmail or Facebook]




    
    A[Start] --> C{Women/Spouse}
    A[Start] --> D{Gynecologist}
    A[Start] --> E{Fitness Trainer}
    A[Start] --> F{Pschycologist}
    A[Start] --> FF{Path Labs}

    F --> G[First Name, Last Name]
    E --> G[First Name, Last Name]
    D --> G[First Name, Last Name]
    C --> G[First Name, Last Name]
    FF --> G[First Name, Last Name]
    G --> H[Age]
    H --> I[Email Address]
    I --> J[Contact Number]
    J --> K[Location/Pincode]


    D --> D.1[Years of Experience]
    D.1 --> D.2[Degree]
    F --> D.1
    E --> D.1

    FF --> FF.1[need to think]
    FF.1 --> FF.2[Websites]
    
    

   

 