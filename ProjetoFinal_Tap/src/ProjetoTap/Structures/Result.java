package ProjetoTap.Structures;

public class Result
{
    public boolean error;
    public String message;
    public Object returnObject;
    public Class returnClass;

    public Result(boolean error)
    {
        this.error = error;
    }

    public Result(boolean error, String message)
    {
        this.error = error;
        this.message = message;
    }

    public Result(boolean error, Object returnObject)
    {
        this.error = error;
        this.returnObject = returnObject;
        this.returnClass = returnObject.getClass();
    }

    public Result(boolean error, Object returnObject, Class returnClass)
    {
        this.error = error;
        this.returnObject = returnObject;
        this.returnClass = returnClass;
    }

    public Result(boolean error, String message, Object returnObject)
    {
        this.error = error;
        this.message = message;
        this.returnObject = returnObject;
        this.returnClass = returnObject.getClass();
    }
}