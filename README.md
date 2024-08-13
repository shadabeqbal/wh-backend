# wh-backend
# Example Flowchart
Women
```mermaid
flowchart TD
    A[Start] --> B{Women}
    A[Start] --> C{Gynecologist}
    A[Start] --> D{Fitness Trainer}
    A[Start] --> E{Pschycologist}
    A[Start] --> F{Path Labs}
    G -->|Yes| C[Continue]
    H -->|No| D[Fix it]
    I --> E{Fixed?}
    J -->|Yes| C[Continue]
    K -->|No| F[Retry]
    L --> D
    M --> G[Finish]

 