public class RendererFactory {
    public RendererFactory() {
    }

    public Renderer buildRenderer(String type, int size) {
        /**
         * Builds a renderer based on the provided type and size.
         *
         * @param type The type of renderer to build ("console" or "none").
         * @param size The size parameter for the renderer.
         * @return A renderer instance corresponding to the specified type,
         *         or null if the type is unknown.
         */
        switch (type) {
            case "console":
                return new ConsoleRenderer(size);
            case "none":
                return new VoidRenderer();
            default:
                System.out.println(Constants.UNKNOWN_RENDERER_NAME);
                return null;
        }
    }
}
