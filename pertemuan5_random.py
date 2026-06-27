import random

print("Angka acak 0-1:", random.random())
print("Angka acak 1–10:", random.randint(1, 10))

buah = ["apel", "pisang", "mangga", "jeruk"]

print("Buah acak:", random.choice(buah))

random.shuffle(buah)
print("Urutan acak:", buah)

print("2 sampel buah:", random.sample(buah, 2))