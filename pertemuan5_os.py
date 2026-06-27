import os
print("Direktori sekarang:", os.getcwd())

folder = "contoh_folder"
if not os.path.exists(folder):
  os.mkdir(folder)
print("Folder dibuat:", folder)

print("Isi direktori:", os.listdir())

os.rename(folder, "folder_baru")
print("Folder diubah namanya menjadi folder_baru")