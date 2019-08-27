import collections
class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        secret_count = collections.Counter(secret)
        guess_count = collections.Counter(guess)
        intersection = secret_count & guess_count
        tempB = 0
        for key,val in intersection.items():
            tempB += val
        
        tempA = 0
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                tempB -= 1
                tempA += 1
        
        return str(tempA) + 'A' + str(tempB) + 'B'
                