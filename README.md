[![Java CI with Gradle](https://github.com/heitzuli/EventShuffle/actions/workflows/gradle.yml/badge.svg)](https://github.com/heitzuli/EventShuffle/actions/workflows/gradle.yml)

## Event Shuffle

### Database
While Googling how to document databases I found this [mermaid](https://mermaid.js.org/syntax/entityRelationshipDiagram.html)

_"You're the one who insisted on bringing the bloody mermaid!"_

```mermaid
erDiagram
    EVENT ||--|{ DATE : "has as options"
    EVENT ||--o{ VOTE : "has"
    EVENT {
        int id
        varchar(250) name
    }
    DATE ||--o{ VOTE : "is voted on by"
    DATE {
        int id
        int event_id
        date date
    }
    VOTE {
        int id
        int event_id
        int date_id
        varchar(250) person
    }
```