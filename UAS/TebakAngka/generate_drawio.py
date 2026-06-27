import xml.etree.ElementTree as ET

def add_node(parent_node, id, value, style, x, y, w=120, h=60):
    cell = ET.SubElement(parent_node, "mxCell", id=id, value=value, style=style, vertex="1", **{"parent": "1"})
    ET.SubElement(cell, "mxGeometry", x=str(x), y=str(y), width=str(w), height=str(h), **{"as": "geometry"})

def add_edge(parent_node, id, source, target, value=""):
    style = "edgeStyle=orthogonalEdgeStyle;rounded=1;orthogonalLoop=1;jettySize=auto;html=1;"
    cell = ET.SubElement(parent_node, "mxCell", id=id, value=value, style=style, edge="1", source=source, target=target, **{"parent": "1"})
    ET.SubElement(cell, "mxGeometry", relative="1", **{"as": "geometry"})

mxfile = ET.Element("mxfile", version="21.1.2")
diagram = ET.SubElement(mxfile, "diagram", name="Flowchart", id="diag1")
model = ET.SubElement(diagram, "mxGraphModel", dx="1000", dy="1000", grid="1", gridSize="10", guides="1", tooltips="1", connect="1", arrows="1", fold="1", page="1", pageScale="1", pageWidth="1200", pageHeight="1900")
root = ET.SubElement(model, "root")
ET.SubElement(root, "mxCell", id="0")
ET.SubElement(root, "mxCell", id="1", parent="0")

S_PROC = "rounded=1;whiteSpace=wrap;html=1;fillColor=#dae8fc;strokeColor=#6c8ebf;"
S_IO = "shape=parallelogram;perimeter=parallelogramPerimeter;whiteSpace=wrap;html=1;fixedSize=1;fillColor=#fff2cc;strokeColor=#d6b656;"
S_DEC = "rhombus;whiteSpace=wrap;html=1;fillColor=#f8cecc;strokeColor=#b85450;"
S_ELL = "ellipse;whiteSpace=wrap;html=1;fillColor=#d5e8d4;strokeColor=#82b366;"
S_ELL_END = "ellipse;whiteSpace=wrap;html=1;fillColor=#ffe6cc;strokeColor=#d79b00;"

add_node(root, "Start", "Mulai Program", S_ELL, 400, 40)
add_node(root, "TampilMenu", "Tampilkan Menu Utama", S_IO, 400, 140, 160, 60)
add_node(root, "CekMenu", "Pilih Menu?", S_DEC, 400, 240, 140, 80)
add_node(root, "TampilRiwayat", "Tampilkan Riwayat Skor", S_PROC, 650, 250, 150, 60)
add_node(root, "End", "Selesai", S_ELL_END, 150, 250, 120, 60)

add_node(root, "InputNama", "Masukkan Nama Pemain", S_IO, 400, 360, 180, 60)
add_node(root, "AcakAngka", "Komputer Memilih Angka 1-100", S_PROC, 400, 460, 160, 60)
add_node(root, "LoopRonde", "Awal Ronde", S_ELL, 400, 560, 120, 60)
add_node(root, "MulaiTimer", "Jalankan Timer 10 Detik", S_PROC, 400, 660, 160, 60)
add_node(root, "InputTebakan", "Input Tebakan", S_IO, 400, 760, 140, 60)

add_node(root, "CekTimeout", "Waktu Habis?", S_DEC, 400, 860, 140, 80)
add_node(root, "PesanHabis", "Pesan: Waktu Habis", S_PROC, 150, 870, 120, 60)

add_node(root, "CekValidasi", "Input Valid?", S_DEC, 400, 980, 140, 80)
add_node(root, "PesanErrorFormat", "Pesan: Harus Angka", S_PROC, 650, 990, 120, 60)

add_node(root, "CekTebakan", "Cek Tebakan vs Acak", S_DEC, 400, 1100, 140, 80)
add_node(root, "PesanBesar", "Pesan: Terlalu Besar", S_PROC, 150, 1110, 120, 60)
add_node(root, "PesanKecil", "Pesan: Terlalu Kecil", S_PROC, 650, 1110, 120, 60)

add_node(root, "PesanBenar", "Pesan: BENAR!", S_PROC, 400, 1220, 120, 60)
add_node(root, "TambahSkor", "Tambah Skor Pemain", S_PROC, 400, 1320, 140, 60)

add_node(root, "TanyaLanjut", "Main Lagi? (y/n)", S_IO, 400, 1420, 140, 60)
add_node(root, "KeputusanLanjut", "Apakah 'y'?", S_DEC, 400, 1520, 140, 80)

add_node(root, "SimpanSkor", "Simpan & Akumulasi Skor", S_PROC, 400, 1640, 140, 60)

add_edge(root, "e1", "Start", "TampilMenu")
add_edge(root, "e2", "TampilMenu", "CekMenu")
add_edge(root, "e3", "CekMenu", "TampilRiwayat", "Menu 2")
add_edge(root, "e4", "TampilRiwayat", "TampilMenu")
add_edge(root, "e5", "CekMenu", "End", "Menu 3")
add_edge(root, "e6", "CekMenu", "InputNama", "Menu 1")
add_edge(root, "e7", "InputNama", "AcakAngka")
add_edge(root, "e8", "AcakAngka", "LoopRonde")
add_edge(root, "e9", "LoopRonde", "MulaiTimer")
add_edge(root, "e10", "MulaiTimer", "InputTebakan")
add_edge(root, "e11", "InputTebakan", "CekTimeout")
add_edge(root, "e12", "CekTimeout", "PesanHabis", "Ya")
add_edge(root, "e13", "PesanHabis", "TanyaLanjut")
add_edge(root, "e14", "CekTimeout", "CekValidasi", "Tidak")
add_edge(root, "e15", "CekValidasi", "PesanErrorFormat", "Bukan Angka")
add_edge(root, "e16", "PesanErrorFormat", "LoopRonde")
add_edge(root, "e17", "CekValidasi", "CekTebakan", "Ya (Angka)")
add_edge(root, "e18", "CekTebakan", "PesanBesar", "> Angka")
add_edge(root, "e19", "PesanBesar", "LoopRonde")
add_edge(root, "e20", "CekTebakan", "PesanKecil", "< Angka")
add_edge(root, "e21", "PesanKecil", "LoopRonde")
add_edge(root, "e22", "CekTebakan", "PesanBenar", "Benar")
add_edge(root, "e23", "PesanBenar", "TambahSkor")
add_edge(root, "e24", "TambahSkor", "TanyaLanjut")
add_edge(root, "e25", "TanyaLanjut", "KeputusanLanjut")
add_edge(root, "e26", "KeputusanLanjut", "AcakAngka", "Ya")
add_edge(root, "e27", "KeputusanLanjut", "SimpanSkor", "Tidak")
add_edge(root, "e28", "SimpanSkor", "TampilMenu")

xml_str = ET.tostring(mxfile, encoding="unicode")
final_xml = '<?xml version="1.0" encoding="UTF-8"?>\n' + xml_str

with open("Flowchart_TebakAngka.drawio", "w", encoding="utf-8") as f:
    f.write(final_xml)
