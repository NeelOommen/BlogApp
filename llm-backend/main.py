from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
from llmobj import summobj

class Item(BaseModel):
    textBody: str


summarizerObj = summobj()

app = FastAPI()

origins = [
    "http://localhost:3000",
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get('/testroute')
def testRoute():
    return {"summary":"hello"}

@app.post('/summarize')
def getSummary(item: Item):

    summary = summarizerObj.summarize(item.textBody)

    return {"summary": summary}