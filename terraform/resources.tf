resource "aws_instance" "app" {
  instance_type = var.instanceType
  ami           = var.imageId
  tags = {
    Name = "InfnetDevopsAppServerInstance"
  }
}
