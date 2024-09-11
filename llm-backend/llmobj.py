from summarizer import Summarizer

class summobj:
    def __init__(self) -> None:
        self.model = Summarizer()

    
    def summarize(self, inp : str) -> str:
        result = ''.join(self.model(inp, min_length=60))

        return result