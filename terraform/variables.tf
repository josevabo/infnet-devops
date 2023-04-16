variable "instanceType" {
  type        = string
  default     = "t2.micro"
  description = "Instância do tipo t2.micro na AWS"
}

variable "imageId" {
  type        = string
  default     = "ami-830c94e3"
  description = "Identificador da imagem da instância criada"
}
