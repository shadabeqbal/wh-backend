# wh-backend
# Example Flowchart

 G -->|Yes| C[Continue]
    H -->|No| D[Fix it]
    I --> E{Fixed?}
    J -->|Yes| C[Continue]
    K -->|No| F[Retry]
    L --> D
    M --> G[Finish]
Women
```mermaid
flowchart TD
    A[Start] --> B{Women}
    A[Start] --> C{Gynecologist}
    A[Start] --> D{Fitness Trainer}
    A[Start] --> E{Pschycologist}
    A[Start] --> F{Path Labs}

    F --> G[First Name, Last Name]
    E --> G[First Name, Last Name]
    D --> G[First Name, Last Name]
    C --> G[First Name, Last Name]
    B --> G[First Name, Last Name]
    G --> H[Age]
    G --> I[Email Address]
    I --> J[Location/Pincode]
   

   

 